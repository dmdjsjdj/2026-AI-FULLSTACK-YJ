// sagas/__test__/postSaga.test.js
import { call, put } from 'redux-saga/effects';
import axios from 'axios';
import  {  fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
            fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
            createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
            updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
            deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
            resetUserState // 초기화
} from '../../reducers/postReducer';
import { fetchPosts, fetchPostDetail, createPost, updatePost, deletePost } from '../postSaga';

jest.mock('axios');

describe('post saga', ()=>{
    afterEach(()=> { jest.clearAllMocks()} );
    // 전체글 게시글조회
    it('fetchPosts success', ()=> {
        const generator = fetchPosts(fetchPostsRequest());
        expect( generator.next().value.type ).toBe('CALL');

        const mockData = [{id:1, content: 'post 1'}];
        const putStep = generator.next({data:mockData}).value;

        expect( putStep ).toEqual(put(fetchPostsSuccess(mockData)))
        expect(generator.next().done).toBe(true);
    });
    
    // 2. 단건조회 (상세보기)
    it('fetchPostDetail success', () => {
        const postId = 1;
        const generator = fetchPostDetail(fetchPostDetailRequest(postId)); 
        expect(generator.next().value.type).toBe('CALL');

        const mockData = { id: 1, content: 'post 1 detail detail' };
        const putStep = generator.next({ data: mockData }).value;

        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
        expect(generator.next().done).toBe(true);
    });

    // 3. 게시글 작성
    it('createPost success', () => {
        const newData = { content: 'new post content' };
        const generator = createPost(createPostRequest(newData));
        expect(generator.next().value.type).toBe('CALL');

        const mockResponseData = { id: 3, content: 'new post content' };
        const putStep = generator.next({ data: mockResponseData }).value;

        expect(putStep).toEqual(put(createPostSuccess(mockResponseData)));
        expect(generator.next().done).toBe(true);
    });

    // 4. 게시글 수정
    it('updatePost success', () => {
        const updatePayload = { postId: 1, dto: { content: 'updated content' } };
        const generator = updatePost(updatePayload); // 리듀서 액션 객체나 매개변수 구조에 맞춤
        expect(generator.next().value.type).toBe('CALL');

        const mockResponseData = { id: 1, content: 'updated content' };
        const putStep = generator.next({ data: mockResponseData }).value;

        expect(putStep).toEqual(put(updatePostSuccess(mockResponseData)));
        expect(generator.next().done).toBe(true);
    });

    // 5. 게시글 삭제
    it('deletePost success', () => {
        const deletePostId = 1;
        const generator = deletePost(deletePostRequest(deletePostId));
        expect(generator.next().value.type).toBe('CALL');

        const putStep = generator.next().value;

        expect(putStep).toEqual(put(deletePostSuccess(deletePostId)));
        expect(generator.next().done).toBe(true);
    });
});

 //npm test  postSaga.test.js