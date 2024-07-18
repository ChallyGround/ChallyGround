import logo from './logo.svg';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import MyPage from './pages/user/MyPage'; // 컴포넌트명은 대문자로 시작하는 것이 좋습니다.
import TestAxios from './pages/TestAxios';
import Login from './pages/main/Login';
import Main from './pages/main/Main';
import PrivateRoute from './pages/main/PriavteRoute';

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<PrivateRoute><Main /></PrivateRoute>} />
        <Route path="/test" element={<TestAxios />} />
      </Routes>
    </div>
  );
}

export default App;
