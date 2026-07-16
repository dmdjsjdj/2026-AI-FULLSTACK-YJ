/**
 * reducers/index.js
 * ----------------------
 * 루트리듀셔(rootReducer) 설정파일
 * - 여러개의 리듀셔를 하나로 합쳐서 Redux 스토어에 전달
 * - 현재는 user리듀셔만 포함
 */
import {combineReducers} from 'redux';  //여러개의 리듀셔를 합치는 Redux 함수
import user              from './user'; // 사용자 관련 상태를 관리하는 user 리듀셔
// import post              from './post'; 사용자 관련 상태를 관리하는 post 리듀셔

const rootReducer = combineReducers({
    user,  // post
});

export default rootReducer;