import React from 'react';
import './header.css';

import volunteer from '../../assets/volunteer.svg'
import helparrow from '../../assets/helparrow.svg'
import company from '../../assets/company.svg'
import organizearrow from '../../assets/organizearrow.svg'

const Header = () => {
  return (
	<div className='vmeste__header'>
    <div className='vmeste__header-text'>
      <p><span className='vmeste__header-text_heplp'>поможем</span></p>
      <p><span className='vmeste__header-text_together'>вместе</span></p>
    </div>
    <div className='vmeste__header-picture'>
      <div className='vmeste__header-picture_container'>
        <a href='#anchor'><img src={volunteer} alt='volunteer' className='vmeste__header-picture_container-volunteer' /></a>
        <img src={helparrow} alt='helparrow' className='vmeste__header-picture_container-helparrow' />
      </div>
      <div className='vmeste__header-picture_container'>
        <img src={company} alt='company' className='vmeste__header-picture_container-company' />
        <img src={organizearrow} alt='organizearrow' className='vmeste__header-picture_container-organizearrow' />
      </div>
    </div>
  </div>
  )
}

export default Header;






































// Сделано командой ITHB для MoscowCityHack