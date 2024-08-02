import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './css/App.css';

import Header from './components/Header';
import Sidebar from './components/SideBar';
import Login from './pages/main/Login';
import Main from './pages/main/Main';
import MyPage from './pages/user/MyPage';
import LoginSuccess from './pages/main/LoginSuccess';
import SubmitData from './pages/SubmitData';
import EditUserInfo from './pages/user/EditUserInfo';
import ChallengeForm from './pages/ChallengeForm';

function App() {
  return (
    <div className="app-container">
      <div className="app-content">
        <Sidebar />
        <div className="main-content">
        <Routes>
            <Route path="/chally/chlogin" element={<Login />} />
            <Route path="/chally/home" element={<Main />} />
            <Route path="/chally/submit" element={<SubmitData />} />
            <Route path="/chally/mypage" element={<MyPage />} />
            <Route path="/chally/editUserInfo" element={<EditUserInfo />} />
            <Route path="/chally/login-success" element={<LoginSuccess />} />
            <Route path="/chally/ChallengeForm" element={<ChallengeForm />} />
        </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
