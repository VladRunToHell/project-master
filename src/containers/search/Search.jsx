import React from 'react';
import './search.css';
import 'leaflet/dist/leaflet.css';
// import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';

import search from '../../assets/search.svg'
import searchicon from '../../assets/searchicon.svg'

const Search = () => {
  return (
	<div className='vmeste__search-wrapper'>
    <a id="anchor"></a>
    <div className='vmeste__search-wrapper-right'>
      <div className='vmeste__search-wrapper-right_image'>
        <img src={search} alt='search' sizes=''/>
      </div>
      <div className='vmeste__search-wrapper-right_categories-wrapper'>
        <div className='categories-wrapper1'>
          <div className='vmeste__search-wrapper-right_categories-header'>Категории</div>
          <div className='vmeste__search-wrapper-right_categories-category'>Животные</div>
          <div className='vmeste__search-wrapper-right_categories-category'>Природа</div>
          <div className='vmeste__search-wrapper-right_categories-category'>Люди с ОВЗ</div>
          <div className='vmeste__search-wrapper-right_categories-category'>Дети</div>
          <div className='vmeste__search-wrapper-right_categories-category'>Старшее поколение</div>
        </div>
      </div>
    </div>
    <div className='vmeste__search-wrapper-left'>
      
      <div className='vmeste__search-wrapper-left_search-pane'>
        <input type="text" className='vmeste__search-wrapper-left_search-pane_input'/>
        <img src={searchicon} alt="searchicon" className='vmeste__search-wrapper-left_search-pane_searchicon' />
      </div>
      <div className='vmeste__search-wrapper-left_map'>
        {/* Я НЕ ПОНИМАЮ, ПОЧЕМУ ОНО НЕ РАБОТАТ, ПРИ ТОМ, Я ЗНАЮ, ЧТО ОШИБКА - ДЕГЕНЕРАТСКАЯ, ПРЯМ ЧУВСТВУЮ  */}
        {/* <MapContainer center={[51.505, -0.09]} zoom={13} scrollWheelZoom={false}>
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          <Marker position={[51.505, -0.09]}>
            <Popup>
              A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
          </Marker>
        </MapContainer>        */}
      </div>
    </div>
  </div>
  )
}

export default Search;
