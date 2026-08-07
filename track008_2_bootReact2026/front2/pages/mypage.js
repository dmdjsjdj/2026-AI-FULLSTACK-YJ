//1. 
import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs, message,
} from "antd";
import Router, { useRouter } from "next/router";
import { updateNicknameRequest, updateProfileImageRequest } from "../reducers/authReducer";
import { UploadOutlined } from "@ant-design/icons";

//2. 부품 + export
export default function MyPage(){
    const [form] = Form.useForm(); 

    // Redux에서 회원가입시 저장된 사용자 정보 가져오기 - user
    const {user, updateNicknameSuccess, updateProfileImageSuccess} = useSelector((state)=> state.auth);
    const dispatch = useDispatch();

    console.log("user =", user);
    console.log("ufile =", user?.ufile);
    const router = useRouter();

    const [fileList, setFileList] = useState([]);

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

    const onFinishUpdateNickname = (values) => {
        dispatch(
            updateNicknameRequest({
                userId: user.id,
                nickname: values.nickname,
            })
        );
    };
    const onFinishUpdateProfileImage = (values) => {
        dispatch(
            updateProfileImageRequest({
                userId: user.id,
                file: values.file,
            })
        );
    };

    // const onFinishUpdateProfileImage = (info) => {
    //     if (info.file.status !== 'uploading') {
    //         dispatch(updateProfileImageRequest({image: info.file.originFileObj, userId: user.id}));
    //     }
    // };

    /////////////////
    return (
        <div style={{maxWidth: 600, margin: "40px auto"}}>
            <Card title="마이페이지 (회원정보)">
                <div style={{display:"flex", alignItems:"center", gap:"20px"}}>
                    
                    <Avatar
                        size={72}
                        src={
                            user.ufile
                                ? `http://localhost:8080/${user.ufile}`
                                : undefined
                        }
                    >
                        {user.nickname?.[0]}
                    </Avatar>
                    <Descriptions title="User Info" bordered column={1}>
                        <Descriptions.Item label="회원 번호">{user.id}</Descriptions.Item>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                    </Descriptions>
                </div>

                {/* 닉네임 수정 */}
                <Form  
                    layout="inline"
                    style={{ marginBottom: 20, marginTop: 40}}
                    onFinish={onFinishUpdateNickname}
                >
                    <Form.Item
                        name="nickname" 
                    >
                        <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            닉네임 변경
                        </Button>
                    </Form.Item>
                </Form>

                {/* 프로필 수정 */}
                <Form
                    layout="inline"
                    style={{ marginBottom: 20, marginTop: 40}}
                    onFinish={onFinishUpdateProfileImage}>
                    <Form.Item>
                        <Upload 
                            beforeUpload={()=>false}
                            fileList={fileList}
                            onChange={({fileList})=> setFileList(fileList)} 
                            maxCount={1}
                        >
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                    <Button
                        type="primary" 
                        onClick={()=>{ 
                            if(!user || fileList.length === 0){
                                message.warning("변경할 이미지를 선택하세요."); return;
                            }
                        const file = fileList[0]?.originFileObj;
                        console.log(file);
                        dispatch(updateProfileImageRequest({ userId: user.id, file, }) );
                        setFileList([]);
                    }} 
                    >
                        프로필 이미지 변경
                    </Button>
                </Form> 
            </Card>
        </div>
    );
}


// export default function MyPagePage(){
//     return "MyPage"
// }