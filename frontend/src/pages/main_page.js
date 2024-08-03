import React, { useState, useEffect } from 'react';
import './main_page.css';

function MainPage() {
  const [currentSlide, setCurrentSlide] = useState(0);
  const [categoryMenuVisible, setCategoryMenuVisible] = useState(false);
  const slides = [
    { src: 'https://via.placeholder.com/1200x300.png?text=Banner+Image+1', link: 'page1.html' },
    { src: 'https://via.placeholder.com/1200x300.png?text=Banner+Image+2', link: 'page2.html' }
  ];

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentSlide((prevSlide) => (prevSlide + 1) % slides.length);
    }, 2000);
    return () => clearInterval(interval);
  }, [slides.length]);

  const toggleCategoryMenu = () => {
    setCategoryMenuVisible(!categoryMenuVisible);
  };

  const updateCurrentTime = () => {
    const now = new Date();
    const formattedTime = `${now.getFullYear()}.${String(now.getMonth() + 1).padStart(2, '0')}.${String(now.getDate()).padStart(2, '0')}.${String(now.getHours()).padStart(2, '0')}:${String(now.getMinutes()).padStart(2, '0')}`;
    return formattedTime;
  };

  return (
    <div className="MainPage">
      <header>
        <div className="header-content">
          <a href="main_page.html" className="logo">
            <img src="logo.png" alt="챌리그라운드 로고" />
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
      <main className="main-content">
        <div className="left-content">
          <div className="hero-slider">
            <div className="slides">
              {slides.map((slide, index) => (
                <div className="slide" key={index} style={{ display: index === currentSlide ? 'block' : 'none' }}>
                  <a href={slide.link}>
                    <img src={slide.src} alt={`배너 이미지 ${index + 1}`} />
                  </a>
                </div>
              ))}
            </div>
            <div className="slider-button-container">
              <button className="slider-button prev" onClick={() => setCurrentSlide((currentSlide - 1 + slides.length) % slides.length)}>◀</button>
              <span className="slider-info">{currentSlide + 1} / {slides.length}</span>
              <button className="slider-button next" onClick={() => setCurrentSlide((currentSlide + 1) % slides.length)}>▶</button>
            </div>
          </div>

          <div className="category-container">
            <div className="category1">
              <a href="category1.html" className="category-item">
                <img src="https://via.placeholder.com/100x60.png?text=Category+1" alt="카테고리 1" />
                <span>카테고리 1</span>
              </a>
            </div>
            <div className="category2">
              <a href="category2.html" className="category-item">
                <img src="https://via.placeholder.com/100x60.png?text=Category+2" alt="카테고리 2" />
                <span>카테고리 2</span>
              </a>
            </div>
            <div className="category3">
              <a href="category3.html" className="category-item">
                <img src="https://via.placeholder.com/100x60.png?text=Category+3" alt="카테고리 3" />
                <span>카테고리 3</span>
              </a>
            </div>
          </div>

          <div className="featured-challenges">
            <h2>주목할 만한 챌린지</h2>
            <div className="challenge-items">
              <div className="challenge-item" data-url="challenge1_detail.html">
                <div className="challenge-image-container">
                  <img src="https://via.placeholder.com/120x80.png?text=Challenge+1" alt="챌린지 1" />
                  <button className="favorite-btn" data-favorite="false">
                    <span className="heart-icon">&#9825;</span>
                  </button>
                </div>
                <div className="challenge-info">
                  <h3>챌린지 1</h3>
                  <p>설명 텍스트 1</p>
                </div>
              </div>
              <div className="challenge-item" data-url="challenge2_detail.html">
                <div className="challenge-image-container">
                  <img src="https://via.placeholder.com/120x80.png?text=Challenge+2" alt="챌린지 2" />
                  <button className="favorite-btn" data-favorite="false">
                    <span className="heart-icon">&#9825;</span>
                  </button>
                </div>
                <div className="challenge-info">
                  <h3>챌린지 2</h3>
                  <p>설명 텍스트 2</p>
                </div>
              </div>
              <div className="challenge-item" data-url="challenge3_detail.html">
                <div className="challenge-image-container">
                  <img src="https://via.placeholder.com/120x80.png?text=Challenge+3" alt="챌린지 3" />
                  <button className="favorite-btn" data-favorite="false">
                    <span className="heart-icon">&#9825;</span>
                  </button>
                </div>
                <div className="challenge-info">
                  <h3>챌린지 3</h3>
                  <p>설명 텍스트 3</p>
                </div>
              </div>
              <div className="challenge-item" data-url="challenge4_detail.html">
                <div className="challenge-image-container">
                  <img src="https://via.placeholder.com/120x80.png?text=Challenge+4" alt="챌린지 4" />
                  <button className="favorite-btn" data-favorite="false">
                    <span className="heart-icon">&#9825;</span>
                  </button>
                </div>
                <div className="challenge-info">
                  <h3>챌린지 4</h3>
                  <p>설명 텍스트 4</p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <aside className="right-content">
          <div className="popular-challenges">
            <div className="section-header">
              <h2>인기 챌린지</h2>
              <a href="popular_page.html" className="view-all">전체보기</a>
            </div>
            <p className="current-time">{updateCurrentTime()}</p>
            <div className="challenge-items">
              <div className="challenge-item" data-url="challenge4_detail.html">
                <img src="https://via.placeholder.com/120x80.png?text=Challenge+4" alt="챌린지 4" />
                <div className="challenge-info">
                  <div className="challenge-rank">1위</div>
                  <div className="challenge-category">카테고리 A</div>
                  <h3>챌린지 4</h3>
                  <p>설명 텍스트 4</p>
                  <div className="challenge-participants">참여자 수: 123</div>
                </div>
              </div>
              <div className="challenge-item" data-url="challenge5_detail.html">
                <img src="https://via.placeholder.com/120x80.png?text=Challenge+5" alt="챌린지 5" />
                <div className="challenge-info">
                  <div className="challenge-rank">2위</div>
                  <div className="challenge-category">카테고리 B</div>
                  <h3>챌린지 5</h3>
                  <p>설명 텍스트 5</p>
                  <div className="challenge-participants">참여자 수: 456</div>
                </div>
              </div>
            </div>
          </div>
        </aside>
      </main>
      <footer>
        <div className="footer-content">
          <p>&copy; 2024 챌리그라운드. All rights reserved.</p>
        </div>
      </footer>
    </div>
  );
}

export default MainPage;