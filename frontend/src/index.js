import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import AddNewURL from './page/AddNewURL';
import ShowURL from './page/ShowURL';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route index element={<AddNewURL />}/>
        <Route path="/url/:id" element={<ShowURL />}/>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
