// __tests__/postReducer.test.js
import postReducer, {fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure, 
            fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure, 
            createPostRequest, createPostSuccess, createPostFailure,
            updatePostRequest, updatePostSuccess, updatePostFailure,
            deletePostRequest, deletePostSuccess, deletePostFailure, 
            resetUserState
} from '../postReducer';

describe('poat', ()=>{
    const initialState={
        posts: [], // 전체 게시글 목록
        currentPost: null, // 단건 조회된 상세 게시글
        loading: false, 
        error: null,    
        success: false, 
    };
    
    it('fetchPostsRequest & fetchPostsSuccess', ()=>{
        let state = postReducer( initialState, fetchPostsRequest() );
        // 1. fetchPostsRequest() 실행 - 인자없음 
        // 2. 리듀서 툴킷 - {type:fetchPostsRequest payload:undefined} 객체만들기
        // 3. 리듀서의 fetchPostsRequest: (state,action)=>{} 액션받아서 처리 - 상태초기화
        //   action = {type:fetchPostsRequest, payload:undefined}
        expect(state.loading).toBe(true);

        const posts = [{id:1, content:'첫 번째 글'}];
        state = postReducer(initialState, fetchPostsSuccess(posts))
        expect(state.loading).toBe(false);
        expect(state.posts).toEqual(posts);
        expect(state.success).toBe(true);
    });

    it('fetchPostsFailure', ()=>{
        const state = postReducer( initialState, fetchPostsFailure('목록 조회 실패') );
        expect(state.loading).toBe(false);   
        expect(state.error).toBe('목록 조회 실패'); // state.error = action.payload
    });
    /////////////////////////////////
    // === 단건 게시글 ===
    it('fetchPostDetailRequest & fetchPostDetailSuccess', () => {
        let state = postReducer(initialState, fetchPostDetailRequest() );
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);

        const currentPost = {id:1, content:'첫번째게시글'};
        state = postReducer(initialState, fetchPostDetailSuccess(currentPost) );
        expect(state.loading).toBe(false); 
        expect(state.currentPost).toEqual(currentPost);
        expect(state.success).toBe(true);
    });

    it('fetchPostDetailFailure', () => {
        const state = postReducer(initialState, fetchPostDetailFailure("단건 게시글 조회 실패") );
        expect(state.loading).toBe(false);
        expect(state.error).toBe("단건 게시글 조회 실패");
    });

    // === 게시글 작성 ===
    it('createPostRequest & createPostSuccess', () => {
        let state = postReducer(initialState, createPostRequest() );
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);

        const prev = {
            posts: [{id:1, content:'첫번째게시글'}],
            currentPost: null,
            loading: true,
            error: null,  
            success: false,
        }

        const newPost = {id:2, content:'두번째게시글'};
        state = postReducer(prev, createPostSuccess(newPost) );
        expect(state.loading).toBe(false); 
        expect(state.posts).toEqual([newPost, ...prev.posts]);
        expect(state.success).toBe(true);
    });

    it('createPostFailure', () => {
        const state = postReducer(initialState, createPostFailure("게시글 작성 실패") );
        expect(state.loading).toBe(false);
        expect(state.error).toBe("게시글 작성 실패");
    });

    // === 게시글 수정 ===
    it('updatePostRequest & updatePostSuccess', () => {
        let state = postReducer(initialState, updatePostRequest() );
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);

        const prev = {
            posts: [{id:1, content:'첫번째게시글'}],
            currentPost: null,
            loading: true,
            error: null,  
            success: false,
        }

        const updPost = {id:1, content:'게시글내용수정'};
        state = postReducer(prev, updatePostSuccess(updPost) );
        expect(state.loading).toBe(false); 
        expect(state.posts).toEqual([updPost]);
        expect(state.currentPost).toEqual(updPost);
        expect(state.success).toBe(true);
    });

    it('updatePostFailure', () => {
        const state = postReducer(initialState, updatePostFailure("게시글 수정 실패") );
        expect(state.loading).toBe(false);
        expect(state.error).toBe("게시글 수정 실패");
    });

    // === 게시글 삭제 ===
    it('deletePostRequest & deletePostSuccess', () => {
        let state = postReducer(initialState, deletePostRequest() );
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);

        const prev = {
            posts: [{id:1, content:'첫번째게시글'}],
            currentPost: null,
            loading: true,
            error: null,  
            success: false,
        }
        const delPost = {id:1};
        state = postReducer(prev, deletePostSuccess(delPost) );
        expect(state.loading).toBe(false); 
        expect(state.posts).toEqual([]);
        expect(state.success).toBe(true);
    });
    
    
    it('deletePostFailure', () => {
        const state = postReducer(initialState, deletePostFailure("게시글 삭제 실패") );
        expect(state.loading).toBe(false);
        expect(state.error).toBe("게시글 삭제 실패");
    });

    // 초기화
    it('resetUserState' , ()=>{      
        const prev = { ...initialState , loading:true , error:'err' , success: true};
        const state = postReducer( prev, resetUserState() );
        expect(state.loading).toBe(false);    
        expect(state.error).toBeNull(); 
        expect(state.success).toBe(false);
    });
});
// npm test postReducer