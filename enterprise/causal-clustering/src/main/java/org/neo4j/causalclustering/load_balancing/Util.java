/*
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.causalclustering.load_balancing;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.neo4j.causalclustering.discovery.ClientConnector;
import org.neo4j.helpers.AdvertisedSocketAddress;

import static java.util.Collections.emptyList;

public class Util
{
    private Util()
    {
    }

    public static <T> List<T> asList( @SuppressWarnings( "OptionalUsedAsFieldOrParameterType" ) Optional<T> optional )
    {
        return optional.map( Collections::singletonList ).orElse( emptyList() );
    }

    public static Function<ClientConnector,AdvertisedSocketAddress> extractBoltAddress()
    {
        return c -> c.connectors().boltAddress();
    }
}
