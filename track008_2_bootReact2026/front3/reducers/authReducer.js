// reducers/authReducer.js
import { createSlice } from "@reduxjs/toolkit";

//1. 초기화 상태 (공용)
const initialState={
    user: null, // 단건 조회된 사용자 정보
    loading: false, // 로딩상태
    error: null,    // 에러메세지
    success: false, // 성공여부 (insert 할때)
};

//2. 상태변화
const authReducer = createSlice({
    name: "auth",
    initialState,
    reducers: {
        // --- 회원 가입 ---
        signupRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        signupSuccess: (state, action)=>{
            state.loading = false;
            // state.user   = action.payload;  // 가입된 회원정보 저장
            state.success = true;
        },
        signupFailure: (state, action)=>{
            state.loading = false;
            state.error   = action.payload;  // 실패 메세지
            // state.success = false;
        },

        // --- 상태 초기화 ---
        resetUserState: (state)=>{
            state.loading = false;
            state.error   = null; 
            state.success = false;
        },

        // --- 로그인 (세션기반 >> user 정보만 관리)
        loginRequest: (state)=>{
            state.loading = true;
            state.error   = null;
        },
        loginSuccess: (state, action)=>{
            state.loading = false;
            state.user   = action.payload.user || null;               //#### Map<String, Object> key
            state.accessToken   = action.payload.accessToken || null; //#### Map<String, Object> key
            // boot 에서 넘겨주는값
            // return ResponseEntity.ok(Map.of(
            //     "accessToken", accessToken,
            //     "user", user
            // ));
        },
        loginFailure: (state, action)=>{
            state.loading = false;
            state.error   = action.payload; 
            state.success = false;
        },

        // --- 토큰 재발급    ResponseEntity<Map<String, Object>>
        refreshTokenRequest: (state)=>{
            state.loading = true;
        },
        refreshTokenSuccess: (state)=>{
            state.loading = false;
            state.accessToken   = action.payload.accessToken || null;
        },
        refreshTokenFailure: (state)=>{
            state.loading = false;
            state.error   = action.payload;
        },

        // --- 로그아웃
        logoutRequest: (state)=>{
            state.loading = true;
            state.error   = null;
        },
        logoutSuccess: (state)=>{
            state.loading = false;
            state.error   = null;
            state.user    = null; 
            state.accessToken = null;
            state.success = false;
        },
        logoutFailure: (state, action)=>{
            state.loading = false;
            state.error   = action.payload;
        },

        // --- 닉네임 변경
        updateNicknameRequest: (state)=>{
            state.loading = true;
            state.error   = null;
        },
        updateNicknameSuccess: (state, action)=>{
            state.loading   = false;
            state.user      = action.payload;
        },
        updateNicknameFailure: (state, action)=>{
            state.loading     = false;   
            state.error       = action.payload;
        },

        // --- 프로필이미지변경
        updateProfileImageRequest : (state)=>{   
            state.loading  = true;      
        },
        updateProfileImageSuccess : (state, action)=>{
            state.loading     = false;
            state.user = action.payload || null;
        },
        updateProfileImageFailure : (state, action)=>{
            state.loading     = false;  
            state.error       = action.payload;
        },

        // --- 유저추가
        loadUserRequest : (state)=>{   
            state.loading  = true;      
        },
        loadUserSuccess : (state, action)=>{
            state.loading     = false;
            state.user = action.payload || null;
        },
        loadUserFailure : (state, action)=>{
            state.loading     = false;  
            state.error       = action.payload;
            state.user = null;
        },

    },
});

//3. action
export const {signupRequest, signupSuccess, signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure, 
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
    loadUserRequest, loadUserSuccess, loadUserFailure
} = authReducer.actions;

//4. export
export default authReducer.reducer;