// sagas/authSaga.js
import {all, call, put, takeLatest} from 'redux-saga/effects';
import axios from 'axios';
import {
    signupRequest, signupSuccess, signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure, 
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
}from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/api/users'

// === 회원 가입 POST /api/users ===
export const signupApi = (formData) => axios.post(`${USER_API_BASE}/signup`, formData, {
    headers: { "Content-Type": "multipart/form-data" },
  });
export function* signup(action) {
    try {
        const result = yield call(signupApi, action.payload);
        yield put(signupSuccess(result.data));

    } catch(err){
        yield put(signupFailure(err.response?.data?.message || err.message));
    }
}

// --- 로그인 API ---
function loginApi(payload) {
  return axios.post(
    `${USER_API_BASE}/login`,
    payload,
    {
      withCredentials: true
    }
  );
}
export function* login(action) {
    // 
    // action = {type:user/fetchUserRequest , payload: 1}
    try {
        const result = yield call(loginApi, action.payload);
        yield put(loginSuccess(result.data));

    } catch(err){
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}

// --- 로그아웃 API ---
function logoutApi() {
  return axios.post(
    `${USER_API_BASE}/logout`,
    {},
    {
      withCredentials: true
    }
  );
}
export function* logout() {  //##
  try {
    yield call(logoutApi); 
    yield put(logoutSuccess());
  } catch (err) {
    yield put(logoutFailure(err.response?.data?.error || err.message));
  }
}

// --- 닉네임 수정
export const updateNicknameApi=({ userId, nickname })=>
    axios.patch(`${USER_API_BASE}/${userId}/nickname`, null, {
    params: { nickname },
  });
export function* updateNickname(action) {
  try {
    const result = yield call(updateNicknameApi, action.payload); 
    yield put(updateNicknameSuccess(result.data));
  } catch (err) {
    yield put(updateNicknameFailure(err.response?.data?.error || err.message));
  }
}

// --- 프로필 이미지 변경
export function updateProfileImageApi({ userId, file }) {
  const formData = new FormData();
  formData.append("ufile", file);  
  return api.post(`${USER_API_BASE}/${userId}/profile-image`, formData, {
    headers: { "Content-Type": "multipart/form-data" },
  });
}
export function* updateProfileImage(action) {
  try {
    const result = yield call(updateProfileImageApi, action.payload); 
    yield put(updateProfileImageSuccess(result.data));
  } catch (err) {
    yield put(updateProfileImageFailure(err.response?.data?.error || err.message));
  }
}

//1) 여러번 요청와도 1번만
function* watchSignup() { yield takeLatest(signupRequest.type, signup);}
function* watchLogin() { yield takeLatest(loginRequest.type, login);}
function* watchLogout() { yield takeLatest(logoutRequest.type, logout);}
function* watchUpdateNickname() { yield takeLatest(updateNicknameRequest.type, updateNickname);}
function* watchUpdateProfileImage() { yield takeLatest(updateProfileImageRequest.type, updateProfileImage);}


export default function * authSaga() {
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}