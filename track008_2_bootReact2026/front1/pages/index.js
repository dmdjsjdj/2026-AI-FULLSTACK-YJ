// pages/index.js
import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { fetchPostsRequest } from "../reducers/postReducer";
import { useEffect, useState } from "react";
import { Card, Spin } from "antd";


export default function Home(){
    const dispatch = useDispatch();
    //1. 유저정보가져오기 - state.auth
    //2. 게시글정보가져오기 - state.post
    const { posts,loading, error } = useSelector((state)=> state.post)
    // 페이지 처음뜰때 게시글 조회액션
    useEffect(() => {
        dispatch(fetchPostsRequest());
    }, [dispatch]);
    
    ////////////////
    return (
        <div>
        {/* 게시판 리스트 */}
            <h3> 게시글 : {posts.length} </h3>
            {posts.map((post,index)=>(
                <Card key={post.id || index} style={{marginBottom:"10px"}}>
                    <p>{post.content}</p>
                </Card>
            ))}
        </div>
    );
}
// {/* 수정부품 */}
// npm run dev