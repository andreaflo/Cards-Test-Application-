import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

function renderTextWithLineBreaks(text) {
  return text.split('\n').map((line, index) => (
      <span key={index}>
      {line}
        <br />
    </span>
  ));
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
  <App>
    {renderTextWithLineBreaks(`Riga 1\nRiga 2\nRiga 3`)}
  </App>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
