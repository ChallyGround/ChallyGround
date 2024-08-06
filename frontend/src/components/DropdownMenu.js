import React from 'react';
import './DropdownMenu.css';

const categories = [
    { name: '전체', icon: '🔲' },
    { name: '디자인 문구', icon: '📒' },
    { name: '푸드', icon: '🍴' },
    { name: '보드게임·TRPG', icon: '🎲' },
    { name: '캐릭터·굿즈', icon: '🧸' },
    { name: '향수·뷰티', icon: '💄' },
    { name: '디지털 게임', icon: '🎮' },
    { name: '홈·리빙', icon: '🏠' },
    { name: '의류', icon: '👗' },
    { name: '웹툰·만화', icon: '📚' },
    { name: '테크·가전', icon: '🔌' },
    { name: '잡화', icon: '👜' },
    { name: '웹툰 리소스', icon: '✏️' },
    { name: '반려동물', icon: '🐶' },
    { name: '주얼리', icon: '💎' },
    { name: '출판', icon: '📖' },
    { name: '디자인', icon: '🎨' },
    { name: '예술', icon: '🎭' },
    { name: '사진', icon: '📷' },
    { name: '영화·비디오', icon: '🎥' },
    { name: '공연', icon: '🎭' },
    { name: '음악', icon: '🎵' },
];

const DropdownMenu = () => {
    return (
        <div className="dropdown-menu">
            {categories.map((category, index) => (
                <div key={index} className="dropdown-item">
                    {category.icon} {category.name}
                </div>
            ))}
        </div>
    );
};

export default DropdownMenu;
