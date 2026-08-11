import React from "react";
import { Card, Button, Popconfirm, Carousel , Image } from "antd";
export default function PostList({posts, handleEdit, handleDelete}){
    ////////////////
    return (
        <div>
        {/* 게시판 리스트 */}
            <h3> 게시글 : {posts.length} </h3>
            {posts.map((post,index)=>(
                <Card 
                    key={post.id || index} 
                    style={{marginBottom:"10px"}}
                    actions={[
                        <Button type="link" onClick={()=>{handleEdit(post)}}>수정</Button>,
                        <Popconfirm
                            title="정말삭제하시겠습니까?"
                            onConfirm={()=> { handleDelete(post.id) }}
                            okText="예"
                            cancelText="아니오"
                        >
                            <Button type="link">삭제</Button>
                        </Popconfirm>
                    ]}
                >
                {/* 게시글 이미지들 */}
                {post?.imageUrls && post.imageUrls.length>0 &&(
                    <Carousel dots draggable style={{marginBottom:"15px"}}>
                      {post.imageUrls.map((v, idx)=>(
                        <div key={idx} style={{textAlign:"center", background:"#fof2f5"}}>
                            <Image 
                                src={`http://localhost:8080/${v}`}
                                alt={`post image ${idx}`}
                                style={{maxWidth:"100%", height:"300px", objectFit:"cover", borderRadius:"8px"}}/>
                        </div>
                      ))}
                    </Carousel>
                )}

                {/* 게시글 해시태그 */}
                {(post?.hashtags ?? []).length > 0 && (
                    <div>
                        해시태그 : {" "}
                        {post.hashtags.map((tag, idx)=>(
                            <span style={{color:"blue", marginRight:"8px"}}>
                                #{tag}
                            </span>
                        ))}
                    </div>
                )}

                
                <p>{post.content}</p>
                    
                </Card>
            ))}
        </div>
    );
}