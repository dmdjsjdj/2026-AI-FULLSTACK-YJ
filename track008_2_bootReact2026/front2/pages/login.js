import { Form, Input, Button, Typography } from "antd";
import { useDispatch, useSelector } from "react-redux";
import { useRouter } from "next/router";
import { useEffect } from "react";
import { loginRequest } from "../reducers/authReducer";

const { Title } = Typography;

export default function LoginPage() {
    const dispatch = useDispatch();
    const router = useRouter();

    const { user, loading, error } = useSelector((state) => state.auth);

    useEffect(() => {
        if (user) {
            router.replace("/mypage");
        }
    }, [user]);

    const onFinish = (values) => {
        dispatch(loginRequest(values));
    };

    return (
        <div style={{ maxWidth: 400, margin: "60px auto" }}>
            <Title level={3}>로그인</Title>

            {error && (
                <p style={{ color: "red" }}>{error}</p>
            )}

            <Form onFinish={onFinish}>
                <Form.Item
                    name="email"
                    rules={[{ required: true, message: "이메일을 입력하세요." }]}
                >
                    <Input placeholder="이메일" />
                </Form.Item>

                <Form.Item
                    name="password"
                    rules={[{ required: true, message: "비밀번호를 입력하세요." }]}
                >
                    <Input.Password placeholder="비밀번호" />
                </Form.Item>

                <Button
                    type="primary"
                    htmlType="submit"
                    block
                    loading={loading}
                >
                    로그인
                </Button>
            </Form>

            <div style={{ marginTop: 20, textAlign: "center" }}>
                계정이 없으신가요?{" "}
                <a onClick={() => router.push("/signup")}>회원가입</a>
            </div>
        </div>
    );
}