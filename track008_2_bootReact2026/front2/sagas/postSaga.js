// sagas/postSaga.js

import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';  // 프론트엔드나 Saga에서 백엔드 서버로 HTTP 요청을 보내는 라이브러리
import  {  fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
            fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
            createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
            updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
            deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
            resetPostState // 초기화
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhost:8080/api/posts';
// watchFetchPosts          -   GET      /api/posts      전체 게시글 조회
export const fetchPostsAPI = ()=> axios.get(POST_API_BASE);
export function* fetchPosts(action){
    try {
        const result = yield call(fetchPostsAPI, action.payload);
        yield put(fetchPostsSuccess(result.data));
    }catch(err){
        yield put( fetchPostsFailure(err.response?.data?.message || err.message));
    } 
}

// watchFetchPostsDetailR   -   GET      /api/posts/{id}      게시글 단건 조회 
export const fetchPostDetailAPI = (id)=> axios.get(`${POST_API_BASE}/${id}`);
export function* fetchPostDetail(action){
    try {
        const result = yield call(fetchPostDetailAPI, action.payload);
        yield put( fetchPostDetailSuccess(result.data) );
    }catch(err){
        yield put( fetchPostDetailFailure(err.response?.data?.message || err.message));
    } 
}

// watchCreatePost          -   POST     /api/posts         게시글 작성 
export function createPostAPI(payload){ 
    const {userId, dto, files} = payload; // boot 의 컨트롤러
    const formData = new FormData();            // form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => { // dto - content / hashtags
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });

    if (files && files.length > 0) { // 이미지파일들
      files.forEach((f) => formData.append('files', f));
    }
    // http://localhost:8080/api/posts?userId
    return axios.post(`${POST_API_BASE}?userId=${userId}`, formData, {
        headers: {'Content-Type': 'multipart/form-data'},
    });
}
export function* createPost(action){
    try {
        const result = yield call(createPostAPI, action.payload); // action.payload - 사용자가 넘겨준값
        console.log("게시글 등록 성공 =", result.data);
        yield put( createPostSuccess(result.data) );
    }catch(err){
        yield put( createPostFailure(err.response?.data?.message || err.message));
    } 
}

// watchUpdatePost          -   patch      /api/posts/{id}      게시글 수정
export function updatePostAPI(payload){ 
    const {userId, postId, dto, files} = payload; // boot 의 컨트롤러
    const formData = new FormData();            // form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => { // dto - content / hashtags
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });

    if (files && files.length > 0) { // 이미지파일들
      files.forEach((f) => formData.append('files', f));
    }
    // http://localhost:8080/api/posts/${postId}?userId=1
    return axios.patch(`${POST_API_BASE}/${postId}?userId=${userId}`, formData, {
        headers: {'Content-Type': 'multipart/form-data'},
    });
}
export function* updatePost(action){
    try {
        console.log("🔥 updatePost action =", action);
        console.log("🔥 updatePost payload =", action.payload);

        const result = yield call(updatePostAPI, action.payload);

        console.log("🔥 수정 응답 =", result.data);

        yield put( updatePostSuccess(result.data) );
    }catch(err){
        console.log("🔥 수정 실패 =", err);
        console.log("🔥 수정 실패 response =", err.response?.data);

        yield put( updatePostFailure(err.response?.data?.message || err.message));
    } 
}

// watchDeletePost          -   DELETE   /api/posts/{id}      게시글 삭제
export const deletePostAPI = ( id ) => axios.delete(`${POST_API_BASE}/${id}`);
export function* deletePost(action){
    // action = {type:   , payload:{}}
    try {
        yield call(deletePostAPI, action.payload);
        yield put( deletePostSuccess(action.payload) );
    }catch(err){
        yield put( deletePostFailure(err.response?.data?.message || err.message));
    }    
}

// --- watch saga들 ---
function* watchFetchPosts(){ yield takeLatest( fetchPostsRequest.type, fetchPosts ); }
function* watchFetchPostDetail(){ yield takeLatest( fetchPostDetailRequest.type, fetchPostDetail ); }
function* watchCreatePost(){ yield takeLatest( createPostRequest.type, createPost ); }
function* watchUpdatePost(){ yield takeLatest( updatePostRequest.type, updatePost ); }
function* watchDeletePost(){ yield takeLatest( deletePostRequest.type, deletePost ); }

export default function* postSaga() {
    yield all([
        call(watchFetchPosts),
        call(watchFetchPostDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
};