import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import AddNewURL from './page/AddNewURL';
import ShowURL from './page/ShowURL';
import reportWebVitals from './reportWebVitals';
import I18NContext from './i18n/I18NContext';
import i18n from './i18n/en';

ReactDOM.render(
  <React.StrictMode>
    <I18NContext.Provider value={i18n}>
      <BrowserRouter>
        <Routes>
          <Route index element={<AddNewURL />}/>
          <Route path="/url/:id" element={<ShowURL />}/>
        </Routes>
      </BrowserRouter>
    </I18NContext.Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
