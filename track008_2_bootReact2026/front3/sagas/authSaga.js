// sagas/authSaga.js
import {all, call, put, takeLatest} from 'redux-saga/effects';
import api from '../api/axios';
import {
    signupRequest, signupSuccess, signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure, 
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
    loadUserRequest, loadUserSuccess, loadUserFailure
}from '../reducers/authReducer';
import Cookies from 'js-cookie';

const USER_API_BASE = '/auth'

// === 회원 가입 POST /api/users ===
export const signupApi = (formData) => api.post(`${USER_API_BASE}/signup`, formData, {
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
export const loginApi= (payload)=> api.post( 
    `${USER_API_BASE}/login`,
    payload
);
export function* login(action) {
    // 
    // action = {type:user/fetchUserRequest , payload: 1}
    try {
        const result = yield call(loginApi, action.payload);
        // result = ResponseEntity<Map<String, Object>>   boot
        // return ResponseEntity.ok(Map.of( "accessToken", accessToken, "user", user ));
        const accessToken = result.data?.accessToken;
        const user        = result.data?.user;

        if(user && accessToken){
          if(typeof window != "undefined"){
            localStorage.setItem("accessToken", accessToken);
            Cookies.set("accessToken", accessToken);
          }

          yield put(loginSuccess({user, accessToken}));
        }
    } catch(err){
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}

// --- 토큰 재발급 ---
export const refreshApi = ()=>{ return api.post(`${USER_API_BASE}/refresh`);}
export function * refresh(){
  try{
    const result = yield call(refreshApi);
    const newAccessToken = result.data?.accessToken || null;
    if(typeof window != "undefined"){
      localStorage.setItem("accessToken", accessToken);
      Cookies.set("accessToken", accessToken);
    }
    yield put(refreshTokenSuccess({accessToken: newAccessToken}));
  }catch(err){
    yield put(refreshFailure(err.response?.data?.message || err.message));
    yield put(logout());
  }
}


// --- 로그아웃 API ---
export const logoutApi = ()=> api.post(
    `${USER_API_BASE}/logout`
);
export function* logout() {  //##
  try {
      yield call(logoutApi); 
      
      if(typeof window != "undefined"){
        localStorage.removeItem("accessToken");
        Cookies.remove("accessToken");
      }

      yield put(logoutSuccess());
  } catch (err) {
    yield put(logoutFailure(err.response?.data?.error || err.message));
  }
}

// --- 닉네임 수정
export const updateNicknameApi=({ userId, nickname })=>
    api.patch(`${USER_API_BASE}/${userId}/nickname`, null, {
    params: { nickname },
  });
export function* updateNickname(action) {
  try {
    const result = yield call(updateNicknameApi, action.payload); 

    console.log(result.data);

    yield put(updateNicknameSuccess(result.data));
  } catch (err) {
    yield put(updateNicknameFailure(err.response?.data?.error || err.message));
  }
}

// --- 프로필 이미지 변경
export function updateProfileImageApi({ userId, file }) {
  const formData = new FormData();
  formData.append("ufile", file);  
  return api.patch(`${USER_API_BASE}/${userId}/profile-image`, formData, {
    headers: { "Content-Type": "multipart/form-data" },
  });
}
export function* updateProfileImage(action) {
  try {
    const result = yield call(updateProfileImageApi, action.payload); 
    
    console.log(result.data);

    yield put(updateProfileImageSuccess(result.data));
  } catch (err) {
    yield put(updateProfileImageFailure(err.response?.data?.error || err.message));
  }
}


export const loadUserApi = (cookieHeader)=> api.get( `${USER_API_BASE}/me`, {
    Header: {cooKie: cookieHeader || ""},
    withCredentials: true,
});
export function * loadUser(action){
    try {
      const result = yield call(loadUserApi, action.payload?.cooKie); 
      yield put(loadUserSuccess(result.data));
    } catch (err) {
      yield put(loadUserFailure(err.response?.data?.message || err.message));
    }
}


//1) 여러번 요청와도 1번만
function* watchSignup() { yield takeLatest(signupRequest.type, signup);}
function* watchLogin() { yield takeLatest(loginRequest.type, login);}
function* watchLogout() { yield takeLatest(logoutRequest.type, logout);}
function* watchUpdateNickname() { yield takeLatest(updateNicknameRequest.type, updateNickname);}
function* watchUpdateProfileImage() { yield takeLatest(updateProfileImageRequest.type, updateProfileImage);}
function* watchLoadUser() { yield takeLatest(loadUserRequest.type, loadUser);}

export default function * authSaga() {
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
        call(watchLoadUser),
    ]);
}