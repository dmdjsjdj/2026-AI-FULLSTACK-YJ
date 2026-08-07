// pages/index.js

import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { fetchPostsRequest, updatePostRequest, deletePostRequest } from "../reducers/postReducer";
import { Spin } from 'antd';
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

export default function Home() {
    const dispatch = useDispatch();
    // 1. 유저 정보 가져오기 - state.auth
    const { user } = useSelector((state)=> state.auth);     // ###
    // 2. 게시글 정보 가져오기 - state.post
    const { posts, loading, error } = useSelector((state)=> state.post);
    
    // useState 는 []
    // 수정모달: isEditModalVisible, setIsEditModalVisible
    const [ isEditModalVisible, setIsEditModalVisible ] = useState(false);
    const [ uploadFiles, setUploadFiles ] = useState([]);   // ###
    // 수정할글: editPost, setEditPost
    const [ editPost, setEditPost ] = useState(null);
    // 수정기능: handleEditSubmit
    const handleEdit = (post)=> {
        setEditPost(post);
        setIsEditModalVisible(true);

        // 기존 이미지 표시용
        const oldImages = post.imageUrls?.map((url,index)=>({
            uid:`old-${index}`,
            name:url.split("/").pop(),
            status:"done",
            url:`http://localhost:8080/${url}`,
            old:true
        })) || [];

        setUploadFiles(oldImages);
    };

    // ##2. saga 넘기는 데이터 확인 (userId, postId, dto, files)
    const handleEditSubmit = (values) => {

        console.log("🔥 수정 submit editPost =", editPost);
        console.log("🔥 수정 values =", values);

        if(!editPost){
            console.log("❌ 수정할 게시글 없음");
            return;
        }

        const currentPostId = editPost.id;

        const files = uploadFiles
            .filter(file => file.originFileObj)
            .map(file => file.originFileObj);


        dispatch(
            updatePostRequest({
                userId: user.id,
                postId: currentPostId,
                dto:{
                    content: values.content,
                    hashtags: Array.isArray(values.hashtags)
                        ? values.hashtags.join(",")
                        : ""
                },
                files
            })
        );


        setIsEditModalVisible(false);
        setEditPost(null);
        setUploadFiles([]);
    };

    // 삭제기능: handleDelete
    const handleDelete = (postId)=> {
        dispatch ( deletePostRequest(postId) );   // 해당글번호   
    };
    


    // 페이지가 처음뜰 때 게시글 조회 액션 - dispatch
    useEffect( ()=> {
        dispatch(fetchPostsRequest());
    }, [dispatch]);

    ///////////////////////////////////
    return (
        <>
            <PostList
                posts = {posts}
                handleEdit = {handleEdit}
                handleDelete = {handleDelete}
                
            />
            {/* ### 3. Edit 수정파라미터 추가 */}
            <EditPostModal 
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={handleEditSubmit}
                uploadFiles={uploadFiles}
                setUploadFiles={setUploadFiles}
            />
        </>
    );
}

// npm run dev
