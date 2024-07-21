import React from 'react';
import '../css/Sidebar.css';

const Sidebar = () => {
    return (
        <div className="sidebar">
            <div className="user-info">
                <img src="path/to/profile-picture.jpg" alt="Profile" className="profile-picture" />
                <span className="username">홍길동님</span>
            </div>
            <nav>
                <ul>
                    <li>
                        <a href="/">홈</a>
                    </li>
                    <li>
                        <a href="/news">소식</a>
                    </li>
                    <li>
                        <a href="/coupons">쿠폰</a>
                    </li>
                    <li>
                        <a href="/reviews">후기</a>
                    </li>
                    <li>
                        <a href="/challenges">챌린지</a>
                    </li>
                    <li>
                        <a href="/settings">설정</a>
                    </li>
                </ul>
            </nav>
        </div>
    );
};

export default Sidebar;
