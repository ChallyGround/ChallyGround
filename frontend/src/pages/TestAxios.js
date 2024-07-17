import React, { useState } from 'react';
import axios from 'axios';

const TestAxios = () => {
  const [text, setData] = useState('');


  const handleChange = (e) => {
    setData(e.target.value);
  };

  // 서버에 보낼 데이터 객체
  const data = {
    data1: text,
    data2: 'value2',
    data3: 'value3'
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/data', data)
      .then((response) => {
        console.log('Data sent successfully:', response.data);
      })
      .catch((error) => {
        console.log('Error sending data:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Data:
        <input type="text" value={data.data1} onChange={handleChange} />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default TestAxios;
