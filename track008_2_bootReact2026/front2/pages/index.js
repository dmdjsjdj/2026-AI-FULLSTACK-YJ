// pages/index.js
import React, {useEffect, useState} from "react";
import { useSelector, useDispatch } from "react-redux";
import { deletePostRequest, fetchPostsRequest, updatePostRequest } from "../reducers/postReducer";
import { Spin } from "antd";
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";
import { Content } from "antd/lib/layout/layout";


export default function Home(){
    const dispatch = useDispatch();
    //1. 유저정보가져오기 - state.auth
    //2. 게시글정보가져오기 - state.post
    const { posts,loading, error } = useSelector((state)=> state.post)

    //수정모달: isEditModalVisible, setIsEditModalVisible
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    //수정할글: editPost,  setEditPost
    const [editPost,  setEditPost] = useState(false);

    //수정기능: handleEditSubmit
    const handleEdit = (post)=>{
        setEditPost(post); //수정글셋팅
        setIsEditModalVisible(true); // 수정화면 보이게
    }

    const handleEditSubmit=(values)=>{
        dispatch(
            updatePostRequest({ postId: editPost.id, dto:{ content: values.content }})
        );
        setIsEditModalVisible(false);
        setEditPost(null);
    };
    
    // 페이지 처음뜰때 게시글 조회액션
    useEffect(() => {
        dispatch(fetchPostsRequest());
    }, [dispatch]);

    // 삭제기능
    const handleDelete = (postId)=>{
        dispatch(deletePostRequest(postId));
    }
    
    ////////////////
    return (
        <>
            <PostList 
                posts={posts}
                handleEdit={handleEdit}
                handleDelete={handleDelete}
            />
            <EditPostModal 
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={handleEditSubmit}
                
            />
        </>
    );
}
// {/* 수정부품 */}
// npm run dev