// pages/posts/new.js
// 1. import
import { Card, Form, Input, Button, message } from "antd";   
import { useSelector, useDispatch } from "react-redux";   // 전역정보, 이벤트발생
import { useRouter } from "next/router";        // 화면이동
import { createPostRequest } from "../../reducers/postReducer"; // 액션

// 2. export + 부품
function NewPostPage(){
    //1. 유저정보가져오기 (useSelector: 전역정보) Q2. 
    const router = useRouter();
    const dispatch = useDispatch();
    const {loading, error} = useSelector((state)=> state.post); // 글정보
    // 유저정보 user
    const {user} = useSelector((state)=> state.auth);


    //2. 게시글 작성(dispatch(createPostRequest(dto)) : 이벤트발생알림)  Q3
    const onFinish = (values) => {
        const dto = {
            content: values.content ,
            userId: 84
        };
        dispatch(createPostRequest(dto));
        message.success("게시글 작성요청완료");
        router.push("/");
    };
    // 글쓰고나면
    // useEffect(() => {
    //     if (success) {
    //         message.success("게시글 등록이 성공적으로 완료되었습니다.");
    //         router.push(`/mypage`); // 절대 경로로 마이페이지 이동
    //         dispatch(resetUserState()); // 다음 글 작성을 위해 성공 상태 초기화
    //     }
    // }, [success, router, dispatch]);

    if(!user){
        return (
            <div style={{maxWidth: 600, margin: "40px auto"}}>
                <p>로그인된 사용자가 없습니다.</p>
                <Button type="primary" onClick={()=> router.push("/signup")}>
                    회원가입 하러가기
                </Button>
            </div>
        );
    }

    //////////////////////// Q1. View
    return (
        <Card title="게시글 작성" style={{maxWidth: 600, margin: "0 auto"}}>
            <Form onFinish={onFinish}>
                    {/* 내용입력 */}
                    <Form.Item
                        label="내용"
                        name="content"
                        hasFeedback
                        rules={[{ required: true, message: '내용을 입력하세요.' }]}
                    >
                        <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요." />
                    </Form.Item>
                    <Button  type="primary" htmlType="submit" >
                        게시글 작성
                    </Button>
            </Form>
        </Card>
    );
}

// 3. export
export default NewPostPage;
