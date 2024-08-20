#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr 15 22:15:36 2024

@author: emilygoyal
"""
from ps9pr2 import Player
import random

class RandomPlayer(Player):
    
    def next_move(self,b):
        available_col = [col for col in range(b.width) if b.can_add_to(col)]
        col2 = random.choice(available_col)
        self.num_moves += 1
        return col2
