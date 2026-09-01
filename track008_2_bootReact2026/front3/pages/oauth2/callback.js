// 1. import, require
// [ useEffect, useSelector, useState, useDispatch, useRouter ]
// useSelector  - 전역상태  / useDispatch  - 스토어알림
// useState     - 변수     / useEffect    - 이벤트변경감지
// useRouter    - 경로

import { useEffect, useRef } from "react";
import { useRouter } from "next/router";
import { useDispatch } from "react-redux";
import { loginSuccess } from "../../reducers/authReducer";
import axios from "axios";


// String targetUrl = redirectUrl + "?accessToken=" + access;

// 2. 부품 + export
export default function OAuth2CallbackPage() {
    const router = useRouter();     // 경로 이동
    const dispatch = useDispatch(); // 스토어 알림

    useEffect(()=> {
        if( !router.isReady ) {
            return;
        }

        const {accessToken} = router.query;
        if( accessToken ) {
            try {
                localStorage.setItem("accessToken" , accessToken);  // 토큰 저장 
                fetchUser(accessToken); // 로그인한 사용자 정보를 요청

            } catch(err) {
                console.error("OAuth2 callback error:", err);
                router.push("/login");
            }    
        }
    }, [router.isReady, router.query]); // 두 값 중 하나가 바뀌면 useEffect 재실행

    const fetchUser = async (accessToken)=> {   // accessToken 으로 로그인한 사용자 정보 호출
        try {
            const res = await axios.get("http://localhost:8080/auth/me", {
                headers: { Authorization: `Bearer ${accessToken}` },
                withCredentials: true,  // 쿠키 전송
            });
            const user = res.data;
            dispatch(loginSuccess({user, accessToken}));    // authReducer 반환
            router.push("/mypage"); // 경로 이동

        } catch(err) {
            console.error("User fetch error:", err);
            router.push("/login");
        }
    };

    //////////////////////////////////////////////
    return (<p>소셜 로그인 처리 중입니다.</p>);
}