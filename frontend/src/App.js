import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './css/App.css';

import Header from './pages/Header';
import DropdownMenu from './components/DropdownMenu';
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
        <Header />
        <div className="main-content">
        <Routes>
            <Route path="/chally/chlogin" element={<Login />} />
            <Route path="/chally/home" element={<Main />} />
            <Route path="/chally/submit" element={<SubmitData />} />
            <Route path="/chally/mypage" element={<MyPage />} />
            <Route path="/chally/editUserInfo" element={<EditUserInfo />} />
            <Route path="/chally/login-success" element={<LoginSuccess />} />
            <Route path="/chally/ChallengeForm" element={<ChallengeForm />} />
            <Route path="/chally/" element={<Main_page/>} />
            <Route path="/chally/growChally" element={<Chally/>} />
            <Route path="/chally/dropdownmenu" element={<DropdownMenu />} />
        </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
