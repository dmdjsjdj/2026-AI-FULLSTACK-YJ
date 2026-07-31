// 1. require / import
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
import { UploadOutlined } from "@ant-design/icons";   
// store : useSelector(전역), useDispatch(스토어알림이벤트알림)
//  감지 : useEffect(이벤트변경감지), useState(변수)
//  경로 : useRouter
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router"; // 훅 사용을 위해 가져옴
import { signupRequest, resetUserState } from "../reducers/authReducer";
import { useEffect, useState } from "react";

// 2. function (부품)
function SignupPage() {
    const dispatch = useDispatch();
    const router = useRouter(); // 수정: useState() 대신 useRouter() 정상 연결
    const { user, error, success, loading } = useSelector((state) => state.auth);

    // 데이터받아서 회원가입전송
    const onFinish = (values) => {
        // 문법 오류 수정: 객체 구조 선언 정상화 및 대소문자 일치
        const sendData = {
            email: values.email,
            password: values.password, // values.Password -> values.password 수정
            nickname: values.nickname
        };
        dispatch(signupRequest(sendData));
    };

    useEffect(() => {
        if (success) {
            message.success("회원가입이 성공적으로 완료되었습니다.");
            router.push(`/mypage`); // 경로 수정: 절대 경로 '/' 추가
            dispatch(resetUserState());
        }
    }, [success, router, dispatch]);

    /////////////////////// Layout > Row > Col Col
    // 모바일제일작은사이즈: 24     xs={}  모바일2: 16 sm={} 태블릿 : 8  md={} / lg={}
    return (
        <Row justify="center" align="middle" style={{ minHeight: '100vh', padding: '20px' }}>
            <Col xs={24} sm={16} md={10} lg={8}>
                {/* 로딩 인디케이터 중앙 정렬 스타일 보완 */}
                {loading && (
                    <div style={{ textAlign: 'center', marginBottom: '20px' }}>
                        <Spin size="large" tip="가입 처리 중..." />
                    </div>
                )}
                
                {error && <p style={{ color: "red", textAlign: 'center' }}> {error} </p>}
                
                {!success && (
                    <Form layout="vertical" onFinish={onFinish} autoComplete="off">
                        {/* 이메일입력 */}
                        <Form.Item
                            label="이메일"
                            name="email"
                            hasFeedback
                            rules={[
                                { required: true, message: '이메일을 입력하세요.' },
                                { type: 'email', message: '올바른 이메일 형식이 아닙니다.' }
                            ]}
                        >
                            <Input placeholder="이메일 주소를 입력해 주세요" />
                        </Form.Item>

                        {/* 비밀번호입력 */}
                        <Form.Item
                            label="비밀번호"
                            name="password"
                            rules={[{ required: true, message: '비밀번호를 입력하세요.' }]}
                        >
                            <Input.Password placeholder="비밀번호를 입력해 주세요" />
                        </Form.Item>

                        {/* 닉네임 입력 */}
                        <Form.Item
                            label="닉네임"
                            name="nickname"
                            hasFeedback
                            rules={[{ required: true, message: '닉네임을 입력하세요.' }]}
                        >
                            <Input placeholder="사용할 닉네임을 입력해 주세요" />
                        </Form.Item>

                        {/* 버튼 컴포넌트 전체 너비 설정(block)으로 가독성 상향 */}
                        <Button type="primary" htmlType="submit" block loading={loading}>
                            회원가입
                        </Button>
                    </Form>
                )}
            </Col>
        </Row>
    );
}

// 3. export
export default SignupPage;
