import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import StationForm from './components/StationForm.jsx';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App/>}/>
        <Route path='/add' element={<StationForm/>}/>
        <Route path='/edit/:id' element={<StationForm/>}/>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
