import{ useSelector,useDispatch }from 'react-redux'; //전역상태 , 상태알림
import { useState,useEffect } from 'react'; // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router'; // 경로
import { LOAD_USERS_REQUEST,UPDATE_NICKNAME_REQUEST,DELETE_USER_REQUEST,LOG_OUT_REQUEST } from '../reducers/user';

export default function UserPage(){

    const dispatch = useDispatch();
    const router = useRouter();
    const {me,users,isLoading,error} = useSelector( (state)=>state.user);

    const [editId,setEditId]= useState(null);
    const [newNickname,setNewNickname]= useState('');

    // 로그인 여부 체크 및 사용자 목록 불러오기
    useEffect(()=>{
        if(!me){router.push('/login');}
      else{dispatch({type:LOAD_USERS_REQUEST});}
    },[dispatch,me,router]);

    // 로그아웃 후 me가 null이 되면 로그인 페이지로 이동
     useEffect(()=>{
         if(me===null){router.push('/login');}
     },[me,router]);
    
    // 로그아웃
    const onLogout=()=> {
        dispatch({type:LOG_OUT_REQUEST});
    }
    // 삭제
    const onDelete=(id)=>{
        dispatch({type:DELETE_USER_REQUEST,data:{id}});
    }
    // 수정모드
    const onEdit = (u)=> {
        setEditId(u.id);
        setNewNickname(u.nickname);}

    // 수정완료
    const onUpdateNickname = (id) =>{
        dispatch({type:UPDATE_NICKNAME_REQUEST,data:{id,nickname:newNickname}});
        setEditId(null);
        setNewNickname('');
    }

    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자 목록</h3>
            {isLoading && <div className="alert alert-info">{isLoading}</div>}
            {error && <div className="alert alert-danger">{error}</div>}
            <table className="table table-bordered table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">이메일</th>
                        <th scope="col">닉네임</th>
                        <th scope="col">액션</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((u)=>(
                    <tr key={u.id}>
                        <td>{u.email}</td>
                        <td>{editId===u.id
                            ?(<input className='form-control' value={newNickname} onChange={(e)=>setNewNickname(e.target.value)}/>)
                            :(u.nickname)}</td>
                        <td>{editId===u.id
                        ?(<button className='btn btn-primary me-3' onClick={()=>onUpdateNickname(u.id)}>수정완료</button>)
                        :(<button className='btn btn-primary me-3' onClick={()=>onEdit(u)} >수정</button>)}
                        <button className="btn btn-danger me-3" onClick={()=>onDelete(u.id)}>삭제</button>
                        </td>
                    </tr>
                    ))}
                </tbody>
            </table>
            <div className="mt-3 text-end">
            <button className="btn btn-secondary" onClick={onLogout}>로그아웃</button>
            </div>
        </div>
    );
}