// MyPage.js
import React, { useState } from 'react';
import EditUserInfo from './EditUserInfo';
import '../../css/mypage.css';
import Button from '@mui/material/Button';

function MyPage() {
    const [isEditing, setIsEditing] = useState(false);

    const editUserInfo = () => {
        setIsEditing(true);
    };

    const closeEditUserInfo = () => {
        setIsEditing(false);
    };

    return (
        <div id="main">
            <div id="user_box">
                <p id="user_name">user</p>
                <div id="user_picture"></div>
            </div>
            <div className="form">
                <Button type="button" variant="contained" onClick={editUserInfo}>수정하기</Button>
            </div>
            <div>
                <div id="ing">참여중인챌린지
                    <div id="ing-1"></div>
                    <div id="ing-2"></div>
                </div>
                <div id="finish">참여완료 챌린지
                    <div id="finish-1"></div>
                    <div id="finish-2"></div>
                    <div id="finish-3"></div>
                </div>
                <div id="soon">참여예정 챌린지
                    <div id="soon-1"></div>
                    <div id="soon-2"></div>
                </div>
            </div>
            {isEditing && <EditUserInfo closeEditUserInfo={closeEditUserInfo} />}
        </div>
    );
}

export default MyPage;