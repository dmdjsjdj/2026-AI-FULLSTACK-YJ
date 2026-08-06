// sagas/__tests__/authSaga.test.js
// call - 동기 - 제너레이터함수 function* 일시중단 후 결과물 받기 / fork(비동기)
// put - redux 액션처리
import { call, put } from 'redux-saga/effects';
import axios from 'axios';


import { signupRequest, signupSuccess, signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure, 
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
 } from '../../reducers/authReducer';
 import { signup, login, logout, updateNickname, updateProfileImage} from '../authSaga';

 jest.mock('axios');

 describe('auth saga', ()=>{
    afterEach(()=> { jest.clearAllMocks()} );
    // --- 회원가입 --- 
    it('signup success', ()=>{
        const userData = { email: '1@1', password: '1'}; //##1
        const action   = signupRequest(userData);  //##2
        const generator = signup(action);

        //1. 1단계 api성공 가정하에 결과값 전달
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다는 가정하에 결과값 전달
        const mockResponse = {data: {id:1, email: '1@1'} };  //##3
        const putStep = generator.next(mockResponse).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(signupSuccess(mockResponse.data)) );  //##4
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료
    });

    // --- 로그인 ---  
    it('login', () => {
        const userData = {
            email: '1@1',
            password: '1'
        };

        const action = loginRequest(userData);
        const generator = login(action);

        // 1. API 호출
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        // 2. API 성공 응답
        const mockResponse = {
            data: {
                id: 1,
                email: '1@1',
                nickname:'first'
            }
        };

        const putStep = generator.next(mockResponse).value;

        // 3. 로그인 성공 액션
        expect(putStep).toEqual(
            put(loginSuccess(mockResponse.data))
        );

        expect(generator.next().done).toBe(true);
    });

        // --- 로그아웃 API ---
    it('logout success', () => {
        const generator = logout();

        // 1. API 호출
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        // 2. API 성공
        const putStep = generator.next().value;

        // 3. 로그아웃 성공 액션
        expect(putStep).toEqual(
            put(logoutSuccess())
        );

        expect(generator.next().done).toBe(true);
    });
    // --- 닉네임 수정
    it('updateNickname success', () => {
        const userData = {
            userId: 1,
            nickname: '새닉네임'
        };

        const action = updateNicknameRequest(userData);
        const generator = updateNickname(action);

        // 1. API 호출
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        // 2. API 성공 응답
        const mockResponse = {
            data: {
                id: 1,
                nickname: '새닉네임'
            }
        };

        const putStep = generator.next(mockResponse).value;

        // 3. 수정 성공 액션
        expect(putStep).toEqual(
            put(updateNicknameSuccess(mockResponse.data))
        );

        expect(generator.next().done).toBe(true);
    });
    // --- 프로필 이미지 변경
    it('updateProfileImage success', () => {
        const payload = { userId: 1, file: new Blob(['test']) };
        const action = updateProfileImageRequest(payload);
        const generator = updateProfileImage(action);

        // 1. API 호출
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        // 2. API 성공 응답
        const mockResponse = {
            data: {
                id:1,
                ufile: '/profile/profile.png'
            }
        };

        const putStep = generator.next(mockResponse).value;

        // 3. 프로필 이미지 변경 성공 액션
        expect(putStep).toEqual(
            put(updateProfileImageSuccess(mockResponse.data))
        );
        expect(generator.next().done).toBe(true);
    });
 });

 //npm test  authSaga.test.js