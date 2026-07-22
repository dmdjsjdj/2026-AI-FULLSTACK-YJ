import { useSelector, useDispatch } from "react-redux";
import { useState   , useEffect   } from "react";
import { useRouter } from "next/router";
import { SIGN_UP_REQUEST } from "../reducers/user";


// useSelector - 전역상태
// useState    - 변수
// useEffect   - 변경감지
// useDispatch - 스토어알림
// uerRouter   - 경로


export default function JoinPage(){
    //1. 코드
    const dispatch = useDispatch();
    const router   = useRouter();
    const {me, isLoading, error, signUpDone} = useSelector( (state)=> state.user);
    //      변수,   변수셋팅함수
    const [email, setEmail]  = useState('');  // let email=''
    const [password, setPassword]  = useState('');
    const [nickname, setNickname]  = useState('');  // 3. 변수 상태 변경 - REACT DOM ( useState )
    
    const onSubmit = (e)=>{
        e.preventDefault();
        // console.log(  email );    console.log( !email );  //!값이 있다- true
        if(!email.trim()){  alert('이메일을 입력해주세요'); return; }
        if(!password.trim()){  alert('비밀번호를 입력해주세요'); return; }
        if(!nickname.trim()){  alert('닉네임을 입력해주세요'); return; }

        //2. Store: 액션알림 useDispatch
        dispatch({ type: SIGN_UP_REQUEST, data:{email, password, nickname}});
    };
    //5. 상태변화감지
    useEffect(()=>{
        if(signUpDone){  //  경로변경
            router.push({
                pathname:'/login',
                query: {signUpSuccess : 'true' }  // 회원가입 성공여부 주소표시창줄
            })
        }
    }, [signUpDone, router]);

    // 로그인시,,,, me 값이 있다면
    useEffect(()=>{
        if(me) router.push('/users');
    }, [me, router]);


    //2. 뷰 - 렌더링  {}  () , 공백, 닫기태그
    return (
        <div className="container my-4">
            <h3 className="mb-3">회원가입</h3>
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
            {/* 닉네임 입력 */}
            <div className="mb-3">
                <input type="text" className="form-control" 
                       placeholder="닉네임입력" title="닉네임입력"
                       value={nickname}
                       onChange={(e)=>{setNickname(e.target.value);}}/>
            </div>
            {/* 버튼 입력 */}
            <div className="mb-3">
                <button type="submit" className="btn btn-primary w-100" disabled={isLoading}>회원가입</button>
            </div>
            </form>

            {/* 에러 메세지 */}
            {error  && <div className="alert alert-danger mt-3">{error}</div> }
        </div>
    );
}