import React, { useState } from 'react';
import api from '../api/axiosApi';

const SubmitData = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [response, setResponse] = useState(null);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const result = await api.post('/submit', { name, email });
      setResponse(result.data);
    } catch (error) {
      console.log('Error submitting data:', error);
    }
  };

  return (
    <div>
      <h1>Submit Data</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input 
            type="text" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
          />
        </div>
        <div>
          <label>Email:</label>
          <input 
            type="email" 
            value={email} 
            onChange={(e) => setEmail(e.target.value)} 
          />
        </div>
        <button type="submit">Submit</button>
      </form>
      {response && <pre>{JSON.stringify(response, null, 2)}</pre>}
    </div>
  );
};

export default SubmitData;
