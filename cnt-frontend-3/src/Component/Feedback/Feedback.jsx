import React, { useEffect, useState } from 'react'
import "./Feedback.css";
import axios from "axios";

const Feedback = () => {
    const[feedbackdata,setFeedBackData]=useState();

   useEffect(()=>{
        axios.get(`http://localhost:8080/api/feedback/getallfeedbacks`)
        .then((res)=>{
            console.log(res.data);
            setFeedBackData(res.data);
        })
    },[])
  return (
    <>
    
    <div className="x-sql-table">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>FeedBack</th>
              {/* Add more columns as needed */}
            </tr>
          </thead>
          <tbody>
            {feedbackdata?.map((row) => (
              <tr key={row?.id}>
                <td>{row?.fid}</td>
                <td>{row?.username}</td>
                <td>{row?.email}</td>
                <td>{row?.feedback}</td>
                {/* Render additional columns here */}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  )
}

export default Feedback