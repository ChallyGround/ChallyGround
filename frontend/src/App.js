import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './css/App.css';

import Header from './components/Header';
import Sidebar from './components/SideBar';
import TestAxios from './pages/TestAxios';
import Login from './pages/main/Login';
import Main from './pages/main/Main';

function App() {
  return (
    <div>
      <Header />
      <Sidebar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Main />} />
          <Route path="/test" element={<TestAxios />} />
        </Routes>
    </div>
  );
}

export default App;
