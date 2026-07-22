import { useSelector } from "react-redux";

export default function UsersPage() {
    //1. 코드
    // const { users } = useSelector((state) => state.user);
    const users = [
        {
            id: 1,
            email: "test1@test.com",
            nickname: "홍길동",
        },
        {
            id: 2,
            email: "test2@test.com",
            nickname: "김철수",
        }
    ];

    //2. 뷰 - 렌더링  {}  ()
    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자 목록</h3>
            {/* 로딩/에러 상태 표시 */}
            <div className="alert alert-info">로딩 중...</div>
            <div className="alert alert-danger">에러메세지</div>

            {/* 사용자 목록 테이블 */}
            <table className="table table-striped table-bordered table-hover align-middle">
                <caption>사용자 목록</caption>
                <thead>
                    <tr>
                        <th width="45%">이메일</th>
                        <th width="25%">닉네임</th>
                        <th width="30%">액션</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>1@1</td>
                        <td>1</td>
                        <td>
                            <button className="btn btn-primary btn-sm me-2">닉네임 수정</button>
                            <button className="btn btn-danger btn-sm">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </table>
            {/* 로그아웃 버튼 */}            
            <div className="mt-3">
                <button className="btn btn-secondary">로그아웃</button>
            </div>
        </div>
    );
}