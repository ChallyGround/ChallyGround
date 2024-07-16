import logo from './logo.svg';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import MyPage from './pages/MyPage'; // 컴포넌트명은 대문자로 시작하는 것이 좋습니다.

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<MyPage />} />
      </Routes>
    </div>
  );
}

export default App;
