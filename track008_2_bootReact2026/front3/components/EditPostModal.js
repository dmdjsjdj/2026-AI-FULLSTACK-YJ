import { Modal, Button, Form, Input, Upload, Select } from "antd";
import { UploadOutlined } from "@ant-design/icons";
import { useEffect } from "react";

export default function EditPostModal({
    visible,
    onCancel,
    editPost,
    onSubmit,
    uploadFiles,
    setUploadFiles
}) {

    const [form] = Form.useForm();

    useEffect(() => {

        if(visible && editPost){

            form.resetFields();

            form.setFieldsValue({
                content: editPost.content || "",
                hashtags: editPost.hashtags || []
            });
        }

    }, [visible, editPost, form]);


    return (
        <Modal
            title="글 수정"
            open={visible}
            onCancel={onCancel}
            footer={null}
            destroyOnClose
        >

            <Form
                form={form}
                onFinish={onSubmit}
                layout="vertical"
            >

                <Form.Item
                    name="content"
                    label="내용"
                    rules={[
                        {
                            required:true,
                            message:"내용을 입력하세요."
                        }
                    ]}
                >
                    <Input.TextArea rows={4}/>
                </Form.Item>


                <Form.Item
                    name="hashtags"
                    label="해시태그"
                >
                    <Select
                        mode="tags"
                        style={{width:"100%"}}
                        placeholder="해시태그 입력 후 Enter"
                    />
                </Form.Item>


                <Form.Item label="이미지">

                    <Upload
                        multiple
                        listType="picture"
                        beforeUpload={()=>false}
                        fileList={uploadFiles}
                        onChange={({fileList})=>{
                            setUploadFiles(fileList);
                        }}
                    >

                        <Button icon={<UploadOutlined/>}>
                            이미지 선택
                        </Button>

                    </Upload>

                </Form.Item>


                <Button
                    type="primary"
                    htmlType="submit"
                >
                    수정완료
                </Button>

            </Form>

        </Modal>
    );
}