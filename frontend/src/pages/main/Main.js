import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Main = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/home', { withCredentials: true })
      .then(response => setUser(response.data))
      .catch(error => console.error('Error fetching user:', error));
  }, []);

  return (
    <div>
      <h1>Home</h1>
      {user ? <p>Welcome, {user}</p> : <p>Loading...</p>}
    </div>
  );
};

export default Main;