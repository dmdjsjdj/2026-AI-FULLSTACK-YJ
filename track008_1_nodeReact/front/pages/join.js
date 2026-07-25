import { useSelector, useDispatch } from "react-redux";
import { useState   , useEffect   } from "react";
import { useRouter } from "next/router";
import { SIGN_UP_REQUEST, CHECK_EMAIL_REQUEST, CHECK_NICKNAME_REQUEST, } from "../reducers/user";


// useSelector - 전역상태
// useState    - 변수
// useEffect   - 변경감지
// useDispatch - 스토어알림
// uerRouter   - 경로


export default function JoinPage(){
    //1. 코드
    const dispatch = useDispatch();
    const router   = useRouter();
    const {me, isLoading, error, signUpDone,
            emailChecked, nicknameChecked, emailMessage, nicknameMessage,
            emailAvailable, nicknameAvailable,
    } = useSelector( (state)=> state.user);
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
    const onCheckEmail = (e) => {
        if(!email.trim()){  alert('이메일을 입력해주세요'); return; }
        dispatch({
            type: CHECK_EMAIL_REQUEST,
            data: { email },
        });
    };

    const onCheckNickname = () => {
        if(!nickname.trim()){  alert('닉네임을 입력해주세요'); return; }
        dispatch({
            type: CHECK_NICKNAME_REQUEST,
            data: { nickname },
        });
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

    useEffect(()=>{
        if(emailAvailable===true){
            setEmailChecked(true);
            alert("사용 가능한 이메일입니다");
        }

        if(emailAvailable===false){
            setEmailChecked(false);
            alert("이미 사용 중인 이메일입니다");
        }

    },[emailAvailable]);


    useEffect(()=>{
        if(nicknameAvailable===true){
            setNicknameChecked(true);
            alert("사용 가능한 닉네임입니다");
        }

        if(nicknameAvailable===false){
            setNicknameChecked(false);
            alert("이미 사용 중인 닉네임입니다");
        }

    },[nicknameAvailable]);


    //2. 뷰 - 렌더링  {}  () , 공백, 닫기태그
    return (
        <div className="container my-4">
            <h3 className="mb-3">회원가입</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
            {/* 이메일 입력 */}
            <div className="mb-3">
                <div className="input-group">
                    <input
                        type="email"
                        className="form-control"
                        placeholder="이메일 입력"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <button
                        type="button"
                        className="btn btn-outline-secondary"
                        onClick={onCheckEmail}
                    >
                        중복확인
                    </button>
                </div>
            </div>
            {emailMessage  && 
                <div className={emailChecked? "text-success mt-1" : "text-danger mt-1"}>
                    {emailMessage}
                </div> 
            }
            {/* 비밀번호 입력 */}
            <div className="mb-3">
                <input type="password" className="form-control" 
                       placeholder="비밀번호입력" title="비밀번호입력"
                       value={password}
                       onChange={(e)=>{setPassword(e.target.value);}}/>
            </div>
            {/* 닉네임 입력 */}
            <div className="mb-3">
                <div className="input-group">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="닉네임 입력"
                        value={nickname}
                        onChange={(e) => setNickname(e.target.value)}
                    />
                    <button
                        type="button"
                        className="btn btn-outline-secondary"
                        onClick={onCheckNickname}
                    >
                        중복확인
                    </button>
                </div>
            </div>
            {nicknameMessage   && 
                <div className={nicknameChecked? "text-success mt-1" : "text-danger mt-1"}>
                    {nicknameMessage }
                </div> 
            }
            {/* 버튼 입력 */}
            <div className="mb-3">
                <button type="submit" className="btn btn-primary w-100" 
                        disabled={isLoading || !emailChecked || !nicknameChecked}>회원가입</button>
            </div>
            </form>

            {/* 에러 메세지 */}
            {error  && <div className="alert alert-danger mt-3">{error}</div> }
        </div>
    );
}


//////////////////////////////////////////////////////////////
/***
import { useSelector, useDispatch } from 'react-redux';  // 전역상태, 상태알림
import { useState   , useEffect   } from 'react';  // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router';  //경로
import { SIGN_UP_REQUEST , SIGN_UP_RESET , CHECK_EMAIL_REQUEST} from '../reducers/user';  

// useSelector  - 전역상태
// useDispatch  - 스토어알림
// useState     - 변수
// useEffect    - 이벤트변경감지
// useRouter    - 경로
export default function JoinPage(){
    //1. 코드 
    const dispatch = useDispatch();
    const router   = useRouter();
    const {me, isLoading, error, signUpDone
         , isEmailAvailable ,  checkEmailLoading
    } = useSelector( (state)=> state.user);   // 1. Store : 전역상태감지 useSelector
    //     변수  , 변수셋팅함수
    const [email,    setEmail]      = useState('');   // let email=''
    const [password, setPassword]   = useState(''); 
    const [nickname, setNickname]   = useState('');   // 3. 변수 상태 변경 - REACT DOM ( useState )
    // 회원가입 요청액션 dispatch
    const  onSubmit = (e)=>{
        e.preventDefault();
        //console.log(   email  );   console.log(  !email  );   !값이있다 - true
        if(!email.trim())   {  alert('이메일을 입력해주세요.');   return;  }
        if(!password.trim()){  alert('비밀번호를 입력해주세요.');  return;  }
        if(!nickname.trim()){  alert('닉네임을  입력해주세요.');   return;  }

        // 2. Store : 액션알림 useDispatch
        dispatch({  type: SIGN_UP_REQUEST    , data:{ email, password, nickname }  });
    };
    //5. 상태변화 감지 
    // useEffect(() => {
    //     dispatch({type: 'SIGN_UP_RESET'});
    // }, [dispatch]);

    useEffect(()=>{
        if(signUpDone){  // 경로변경
            //router.push({  pathname:'/login',  query:{  signUpSuccess : 'true' } });// 회원가입 성공여부 주소표시창줄
            //router.replace('/login?signUpSuccess=true');
            window.location.href='/login?signUpSuccess=true';   
        }
    } , [signUpDone , router]);

    // 로그인시,,,,,, me 값이 있다면
    useEffect(()=>{
        if(me){ router.push('/users');  console.log(me);  }
    }, [me , router]);

    //6. 이메일중복검사
    const  onCheckEmail = (e)=>{
        e.preventDefault();
        if(!email.trim()){  alert('이메일을 입력해주세요.'); return; }

        dispatch({type: CHECK_EMAIL_REQUEST , data:email});
    };
 
    //2. 뷰 - 레더링    <></> , 공백 , 닫기태그
    return (
        <div  className="container  my-4">
            <h3 className="mb-3">회원가입</h3>
            <form className="w-50 mx-auto"  onSubmit={onSubmit}  >
            {/* 이메일 입력 *}
            <div className="mb-3  input-group">
                <input type="email"  className="form-control"  
                       placeholder="이메일입력" title="이메일입력" 
                       value={email}
                       onChange={(e)=>{setEmail(e.target.value); }}
                       />
                <button className='btn btn-outline-secondary'  
                        type="button"  onClick={onCheckEmail}    disabled={checkEmailLoading}
                > 
                    {checkEmailLoading ? '확인 중..': '중복 확인'} 
                </button>      
            </div>     
            {isEmailAvailable==true && <div className='text-success mb-2'>사용가능한 이메일입니다.</div> }
            {isEmailAvailable==false && <div className='text-danger mb-2'>이미 사용중인 이메일입니다</div>}

            {/* 비밀번호 입력 *}
            <div className="mb-3">
                <input type="password"  className="form-control"  
                    placeholder="비밀번호입력" title="이메일입력"
                    value={password}
                    onChange={(e)=>{setPassword(e.target.value);}}/>
            </div>
            {/* 닉네임 입력 *}
            <div className="mb-3">
                <input type="text"  className="form-control"  
                    placeholder="닉네임" title="닉네임입력"  
                    value={nickname}
                    onChange={(e)=>{  setNickname(e.target.value);}}/>
            </div>
            {/* 버튼 입력 *}
            <div className="mb-3">
                <button  type="submit"  className="btn btn-primary w-100"   disabled={isLoading}>회원가입</button>
            </div>            
            </form>
            
            {/* 에러 메시지 *}
            {error  && <div className="alert  alert-danger mt-3">{error}</div>  }
        </div>
    );
} */