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
        <div className="main">

       
            <div> 
                <div className="user_box">
                    <p className="user_name">user</p>
                    <div className="user_picture"></div>
                    <div className="form">
                    <Button type="button" variant="contained" onClick={editUserInfo}>수정하기</Button>
                    </div>
                </div>

                <div className="ing">참여중인챌린지
                    <div className="ing-1"></div>
                    <div className="ing-2"></div>
                </div>
                <div className="finish">참여완료 챌린지
                    <div className="finish-1"></div>
                    <div className="finish-2"></div>
                    <div className="finish-3"></div>
                </div>
                <div className="soon">참여예정 챌린지
                    <div className="soon-1"></div>
                    <div className="soon-2"></div>
                </div>
            </div>
            {isEditing && <EditUserInfo closeEditUserInfo={closeEditUserInfo} />}
        </div>
    );
}

export default MyPage;