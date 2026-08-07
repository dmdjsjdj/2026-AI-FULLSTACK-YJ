import React, { useEffect } from "react";
import { Provider, useDispatch, useSelector } from "react-redux";
import { Row, Col, Form, Input, Button, Spin, message } from "antd";  
import { useRouter } from "next/router"; 
import { loginRequest, resetUserState } from "../reducers/authReducer";

export default function LoginPage() { 
    //Q1. useDispatch, useSelector 초기화
    const dispatch = useDispatch();
    const router = useRouter();

    //Q2. useSelector 이용해서 유저상태 가져오기 - user, loading, error
    const { user, loading, error } = useSelector(
        (state) => state.auth
    );

    //Q3. 로그인 버튼 누르고나면 - 스토어알림(dispatch) 이용해서 loginRequest 처리
    const onFinish = (values)=> {
        console.log(values);
        dispatch(loginRequest({...values, Provider:"local"}));
    }

    //Q4. 로그인 성공시 00님 환영합니다 메세지 띄우고, 마이페이지로 이동
    useEffect(()=> {
        if(user && user.email){
            message.success(`${user.nickname || user.email}님 환영합니다,`);
            router.push("/mypage");
        }
    }, [user, router]);

    /////////////////////////////////////////////////////////////////////
    return (
        <Row justify="center" style={{marginTop:40}}>
            <Col xs={24} sm={16} md={8}>  
                    {loading && <Spin/>}
                    {error && <p style={{color:"red"}}>{error}</p> }

                    <Form  layout="vertical" onFinish={onFinish}> 
                        <Form.Item 
                            label="이메일"
                            name="email" 
                            rules={[{required:true, message:"이메일을 입력하세요."}]}
                        >
                            <Input />
                        </Form.Item>

                        <Form.Item 
                            label="비밀번호"
                            name="password" 
                            rules={[{required:true, message:"비밀번호를 입력하세요."}]}
                        >
                            <Input.Password placeholder="*****" />
                        </Form.Item>         

                        <div style={{ textAlign: 'center', marginTop: 20 }}>
                            <Button 
                                type="primary" 
                                htmlType="submit"   
                                style={{ width: '200px', height: '50px' }}
                            >
                                로그인
                            </Button>
                        </div>
                    </Form> 
            </Col>
        </Row>
    );
}

export async function getServerSideProps() {
  return { props: {} };
}
