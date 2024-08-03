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
import Main_page from './pages/main_page';
import Chally from './pages/chally';

function App() {
  return (
    <div className="app-container">
      <div className="app-content">
        <Sidebar />
        <div className="main-content">
        <Routes>
            <Route path="/chlogin" element={<Login />} />
            <Route path="/home" element={<Main />} />
            <Route path="/submit" element={<SubmitData />} />
            <Route path="/mypage" element={<MyPage />} />
            <Route path="/editUserInfo" element={<EditUserInfo />} />
            <Route path="/login-success" element={<LoginSuccess />} />
            <Route path="/ChallengeForm" element={<ChallengeForm />} />
            <Route path="/mainPage" element={<Main_page/>} />
            <Route path="/chally" element={<Chally/>} />
        </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
