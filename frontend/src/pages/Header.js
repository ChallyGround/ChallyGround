import React, { useState } from 'react';
import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import './Header.css';
import DropdownMenu from '../components/DropdownMenu';

function Header() {
  const [categoryMenuVisible, setCategoryMenuVisible] = useState(false);

  const toggleCategoryMenu = () => {
    setCategoryMenuVisible(!categoryMenuVisible);
  };

  return (
    <header>
      <div className="header-content">
        <a href="main_page.html" className="logo">
          <img src="../../public/logo.gif" alt="챌리그라운드 로고" />
        </a>
        <div className="header-buttons">
          <button id="challenge-upload" className="btn">챌린지 올리기</button>
          <button id="login-signup" className="btn">로그인/회원가입</button>
        </div>
      </div>
      <nav className="navbar">
        <ul className="nav-list">
          <li id="home" className="nav-item active">홈</li>
          <li id="category" className="nav-item" onClick={toggleCategoryMenu}>카테고리</li>
          <li id="popular" className="nav-item">인기</li>
          <li id="new" className="nav-item">신규</li>
        </ul>
        {categoryMenuVisible && (
          <div id="category-menu" className="category-menu">
            {/* Populate the category menu dynamically if needed */}
          </div>
        )}
        <div className="search-container">
          <input type="text" id="search" placeholder="검색..." />
        </div>
      </nav>
    </header>
  );
}

export default Header;