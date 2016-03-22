/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.hexagonal.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.iluwatar.hexagonal.domain.LotteryTicket;
import com.iluwatar.hexagonal.domain.LotteryTicketRepository;

/**
 * 
 * Mock database for lottery tickets.
 *
 */
public class LotteryTicketRepositoryMock implements LotteryTicketRepository {
  
  private Map<UUID, LotteryTicket> tickets = new HashMap<>();

  @Override
  public Optional<LotteryTicket> findByUuid(UUID uuid) {
    LotteryTicket ticket = tickets.get(uuid);
    if (ticket == null) {
      return Optional.empty();
    } else {
      return Optional.of(ticket);
    }
  }

  @Override
  public Optional<UUID> save(LotteryTicket ticket) {
    UUID uuid = UUID.randomUUID();
    tickets.put(uuid, ticket);
    return Optional.of(uuid);
  }

  @Override
  public Map<UUID, LotteryTicket> findAll() {
    return tickets;
  }
}