import React from 'react';

import { Header, Search, Rating, Footer} from './containers';
import {Navbar} from './components';
import './App.css';

const App = () => {
  return (
	<div className='App'>
		<Navbar />
		<div className='header__bg'>			
			<Header />
		</div>
		<div className='search__bg'>
			<Search />
		</div>
		<div className='rating__bg'>
			<Rating />
		</div>
		<div className='footer__bg'>
			<Footer />
		</div>
	</div>
  )
}

export default App;