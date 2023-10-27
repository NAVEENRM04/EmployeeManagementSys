import React, { useEffect } from 'react'
import './BannedUser.css';
import { motion } from 'framer-motion';
import { useNavigate } from 'react-router-dom';
import { useHistory } from 'react-router-dom';
const BannedUser = () => {
    const navigate = useNavigate();

    const handleOkClick = () => {
      // Clear localStorage
      localStorage.clear();
      // Navigate to the "/login" route
      navigate('/login');
    };
  
    return (
      <div className="background-container">
        <div className="content">
          <h1>Your Account is Banned</h1>
          <button className='banokbut' onClick={handleOkClick}>OK</button>
        </div>
      </div>
    );
  };
export default BannedUser