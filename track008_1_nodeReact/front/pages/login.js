import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";
import { useRouter } from "next/router";
import { LOG_IN_REQUEST } from "../reducers/user";


export default function LoginPage(){
    //1. 코드
    const dispatch = useDispatch();
    const router   = useRouter();
    const {me, isLoading, error} = useSelector( (state)=> state.user);
    //      변수,   변수셋팅함수
    const [email, setEmail]  = useState('');  // let email=''
    const [password, setPassword]  = useState('');
    
    const onSubmit = (e)=>{
        e.preventDefault();
        // console.log(  email );    console.log( !email );  //!값이 있다- true
        if(!email.trim()){  alert('이메일을 입력해주세요'); return; }
        if(!password.trim()){  alert('비밀번호를 입력해주세요'); return; }

        //2. Store: 액션알림 useDispatch
        dispatch({ type: LOG_IN_REQUEST, data:{email, password}});
    };
    // 로그인시,,,, me 값이 있다면
    useEffect(()=>{
        if(me) router.push('/users');
    }, [me]);

    //2. 뷰 - 렌더링  {}  ()
    return (
        <div className="container my-4">
            <h3 className="mb-3">로그인</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
            {/* 이메일 입력 */}
            <div className="mb-3">
                <input type="email" className="form-control" 
                       placeholder="이메일입력" title="이메일입력"
                       value={email}
                       onChange={(e)=>{setEmail(e.target.value);}}/>
            </div>
            {/* 비밀번호 입력 */}
            <div className="mb-3">
                <input type="password" className="form-control" 
                       placeholder="비밀번호입력" title="비밀번호입력"
                       value={password}
                       onChange={(e)=>{setPassword(e.target.value);}}/>
            </div>
            {/* 버튼 입력 */}
            <div className="mb-3">
                <button type="submit" className="btn btn-primary w-100">로그인</button>
            </div>
            </form>
        </div>
    );
}