import React, { useState, useEffect } from 'react';
import './ChallengePage.css';
import api from '../api/axiosApi';

const ChallengesPage = () => {
    const [viewType, setViewType] = useState('grid'); // 'grid' or 'list'
    const [challenges, setChallenges] = useState([]);

    useEffect(() => {
        // Fetch the challenges from the API
        const mockChallenges = [
            { id: 1, title: 'Challenge 1', status: 'ongoing', imageUrl: 'https://via.placeholder.com/150' },
            { id: 2, title: 'Challenge 2', status: 'completed', imageUrl: 'https://via.placeholder.com/150' },
            { id: 3, title: 'Challenge 3', status: 'upcoming', imageUrl: 'https://via.placeholder.com/150' },
            // Add more challenges here...
        ];
        setChallenges(mockChallenges);
        
        const fetchChallenges = async () => {
            try {
                const response = await api.get('/getChallenges');
                setChallenges(response.data);
            } catch (error) {
                console.error('Failed to fetch challenges', error);
            }
        };
        fetchChallenges();
    }, []);

    const handleViewChange = (view) => {
        setViewType(view);
    };

    const filterChallenges = (status) => {
        return challenges.filter(challenge => challenge.status === status);
    };

    const renderChallenges = (challenges) => {
        return challenges.map(challenge => (
            <div key={challenge.id} className={`challenge-item ${viewType}`}>
                <img src={challenge.imageUrl || 'https://via.placeholder.com/150'} alt={challenge.title} />
                <h3>{challenge.title}</h3>
            </div>
        ));
    };

    return (
        <div className="challenges-page">
            <h2>챌린지 목록</h2>
            <div className="view-buttons">
                <button onClick={() => handleViewChange('grid')}>액자식 보기</button>
                <button onClick={() => handleViewChange('list')}>세로식 보기</button>
            </div>
            <div className="challenge-categories">
                <h3>진행중인 챌린지</h3>
                <div className={`challenges-container ${viewType}`}>
                    {renderChallenges(filterChallenges('ongoing'))}
                </div>
                <h3>완료된 챌린지</h3>
                <div className={`challenges-container ${viewType}`}>
                    {renderChallenges(filterChallenges('completed'))}
                </div>
                <h3>앞으로 진행될 챌린지</h3>
                <div className={`challenges-container ${viewType}`}>
                    {renderChallenges(filterChallenges('upcoming'))}
                </div>
            </div>
        </div>
    );
};

export default ChallengesPage;
