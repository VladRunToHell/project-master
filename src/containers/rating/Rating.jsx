import React from 'react';
import './rating.css';

import news from '../../assets/news.svg';
import place1 from '../../assets/1stPlace.svg';
import place2 from '../../assets/2ndPlace.svg';
import place3 from '../../assets/3rdPlace.svg';
import star from '../../assets/star.svg';



const Rating = () => {
  return (
    <div className='vmeste__rating'>
      <div className='vmeste__rating-content_wrapper'>
        <div className='vmeste__rating-content_wrapper-pane_wrapper'>
          <p className='vmeste__rating-content_wrapper-pane_wrapper-header'>Выдающиеся волонтеры</p>
          <div className='vmeste__rating-content_wrapper-pane_wrapper-pane'>
            {/* 1 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place1} alt="place1" className='place-place1'/>
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 2 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place2} alt="place2" className='place-place2' />
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 3 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place3} alt="place3" className='place-place3' />
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 4 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>4</p>
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 5 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>5</p>
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>6</p>
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>7</p>
              <p className='place-name'>ФИО</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>            
          </div>
        </div>
        <img src={news} alt="news" className='vmeste__rating-content_wrapper-img' />
        <div className='vmeste__rating-content_wrapper-pane_wrapper'>
          <p className='vmeste__rating-content_wrapper-pane_wrapper-header'>Лучшие компании</p>
          <div className='vmeste__rating-content_wrapper-pane_wrapper-pane'>
            {/* 1 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place1} alt="place1" className='place-place1'/>
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 2 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place2} alt="place2" className='place-place2' />
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 3 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <img src={place3} alt="place3" className='place-place3' />
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 4 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>4</p>
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            {/* 5 место */}
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>5</p>
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>6</p>
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
            <div className='vmeste__rating-content_wrapper-pane_wrapper-pane_place-wrapper'>
              <p className='place-p'>7</p>
              <p className='place-name'>название</p>
              <p className='place-rating'>ОЧКИ</p>
              <img src={star} alt="star" className='star' />
            </div>
          </div>
        </div>
      </div>
    </div>
  )    
}

export default Rating;