import React from 'react';
import './search.css';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'

import search from '../../assets/search.svg'
import searchicon from '../../assets/searchicon.svg'

const Search = () => {
  return (
	<div className='vmeste__search-wrapper'>
    <div className='vmeste__search-wrapper-right'>
      <div className='vmeste__search-wrapper-right_image'>
        <img src={search} alt='search' sizes=''/>
      </div>
      <div className='vmeste__search-wrapper-right_categories-wrapper'>
        <div className='vmeste__search-wrapper-right_categories-header'>Категории</div>
        <div className='vmeste__search-wrapper-right_categories-category'>Животные</div>
        <div className='vmeste__search-wrapper-right_categories-category'>Природа</div>
        <div className='vmeste__search-wrapper-right_categories-category'>Люди с ОВЗ</div>
        <div className='vmeste__search-wrapper-right_categories-category'>Дети</div>
        <div className='vmeste__search-wrapper-right_categories-category'>Старшее поколение</div>
      </div>
    </div>
    <div className='vmeste__search-wrapper-left'>
      <div className='vmeste__search-wrapper-left_search-pane'>
        <input type="text" className='vmeste__search-wrapper-left_search-pane'/>
        <img src={searchicon} alt="searchicon" className='vmeste__search-wrapper-left_search-pane_searchicon' />
      </div>
      <div className='vmeste__search-wrapper-left_map'>
               
      </div>
    </div>
  </div>
  )
}

export default Search;
